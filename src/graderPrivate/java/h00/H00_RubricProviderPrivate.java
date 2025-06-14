package h00;

import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;
import org.tudalgo.algoutils.tutor.general.json.JsonParameterSet;

import static org.tudalgo.algoutils.tutor.general.jagr.RubricUtils.criterion;


public class H00_RubricProviderPrivate implements RubricProvider {

    public static final Rubric RUBRIC = Rubric.builder()
        .title("H00 | Erste Schritte mit Java & FopBot")
        .addChildCriteria(
            Criterion.builder()
            .shortDescription("H0.1 | Matrikelnummer in Moodle")
                .minPoints(0)
                .maxPoints(1)
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
}
