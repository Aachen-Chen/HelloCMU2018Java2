package BasicExample.FXExamples;

// Basic Property Wrapper
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// Low Level Binding
import javafx.beans.binding.DoubleBinding;

public class ObservableExample {
    public static void main(String[] args){
        DoubleProperty radius = new SimpleDoubleProperty();
        DoubleBinding surface = new DoubleBinding() {
            { super.bind(radius); }
            @Override
            protected double computeValue() {
                return Math.PI * (radius.get() * radius.get());
            }
        };
        surface.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(
                    "Surface: "+
                    Bindings.format("%.2f", ((DoubleBinding)observable)) +
                    " is invalid now!");
            }
        });

        DoubleBinding volumn = new DoubleBinding() {
            { super.bind(radius); }
            @Override
            protected double computeValue() {
                return (4 / 3.) * Math.PI * Math.pow(radius.get(), 3);
            }
        };
        volumn.addListener(((observable, oldValue, newValue) -> {
            double v = newValue.doubleValue();
            System.out.println(
                "New volumn: "+
                String.format("%.2f", v)
            );
        }));

        radius.set(10.);
    }
}






