package h00;

import org.objectweb.asm.*;
import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.GradeResult;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;
import org.sourcegrade.jagr.api.testing.ClassTransformer;
import org.sourcegrade.jagr.api.testing.RubricConfiguration;

import static org.tudalgo.algoutils.tutor.general.jagr.RubricUtils.criterion;


public class H00_RubricProviderPrivate implements RubricProvider {

    public static final Rubric RUBRIC = Rubric.builder()
        .title("H00 | Erste Schritte mit Java & FopBot")
        .addChildCriteria(
            Criterion.builder()
                .shortDescription("H0.1 | Matrikelnummer in Moodle")
                .minPoints(0)
                .maxPoints(1)
                .grader((testCycle, criterion) ->
                    GradeResult.of(0, 1,
                        "See \\<a href=\"https://moodle.informatik.tu-darmstadt.de/mod/assign/view.php?id=76605\"\\>" +
                            "\"Punkt für korrekt eingetragene Matrikelnummer\"\\</a\\> in Moodle"))
            .build(),
            Criterion.builder()
                .shortDescription("H0.4 | Erstes Programm mit dem FopBot")
                .addChildCriteria(
                    criterion("Der Konstruktor von Robot wurde mit korrekten Parametern aufgerufen.",
                        JUnitTestRef.ofMethod(() -> MainTest.class.getDeclaredMethod("testConstructorCall")))
                )
                .minPoints(0)
                .maxPoints(1)
                .build()
        ).build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }

    @Override
    public void configure(RubricConfiguration configuration) {
        RubricProvider.super.configure(configuration);
        configuration.addTransformer(new ClassTransformer() {
            @Override
            public String getName() {
                return "VisibilityTransformer";
            }

            @Override
            public void transform(ClassReader reader, ClassWriter writer) {
                if (reader.getClassName().equals("h00/Main")) {
                    reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
                        @Override
                        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                            return new MethodVisitor(Opcodes.ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                                @Override
                                public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                                    if (owner.equals("fopbot/World") && name.equals("setVisible") && descriptor.equals("(Z)V")) {
                                        super.visitInsn(Opcodes.POP);
                                        super.visitInsn(Opcodes.ICONST_0);
                                    }
                                    super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                                }
                            };
                        }
                    }, 0);
                } else {
                    reader.accept(writer, 0);
                }
            }
        });
    }
}
