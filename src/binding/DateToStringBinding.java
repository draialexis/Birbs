package binding;

import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableObjectValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateToStringBinding extends StringBinding {

    private final ObservableObjectValue<LocalDate> date;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DateToStringBinding(ObservableObjectValue<LocalDate> date) {
        this.date = date;
        bind(date);
    }

    @Override
    protected String computeValue() {
        return date.get().format(dateFormatter);
    }
}
