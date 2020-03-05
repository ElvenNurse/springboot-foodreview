package mate.academy.boot.amazonreview.util;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CsvUtils {
    public <T> List<T> read(Class<T> clazz, File file) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("productId")
                .addColumn("userId")
                .addColumn("profileName")
                .addColumn("helpfulnessNumerator")
                .addColumn("helpfulnessDenominator")
                .addColumn("score")
                .addColumn("time")
                .addColumn("summary")
                .addColumn("text")
                .setSkipFirstDataRow(true)
                .build();
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(file).readAll();
    }
}
