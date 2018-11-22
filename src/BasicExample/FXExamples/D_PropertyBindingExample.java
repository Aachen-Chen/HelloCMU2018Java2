package BasicExample.FXExamples;

// Basic property wrapper type.
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// For bindings class
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;  // Interface

// For low level binding
import javafx.beans.binding.DoubleBinding;  // Abstract class

public class D_PropertyBindingExample {
    // bmi = weight * 703 / height^2
}

class A_FluentAPI {
    DoubleProperty height = new SimpleDoubleProperty();
    DoubleProperty weight = new SimpleDoubleProperty();

    private DoubleProperty bmiProperty = new SimpleDoubleProperty();

    // Set DoubleProperty.set(160)
    A_FluentAPI(){ height.set(160); weight.set(60); }

    double calcBMI(){
        // bind property
        bmiProperty.bind(weight.multiply(703).divide(height.multiply(height)));

        // Get DoubleProperty.get() -> double
        return bmiProperty.get();
    }

    public static void main(String[] args){
        A_FluentAPI o = new A_FluentAPI();
        System.out.println(o.calcBMI());
    }
}

class B_BindingsUtilityClass extends A_FluentAPI {
    // bmi = weight * 703 / height^2
    private NumberBinding bmiNumberBinding = Bindings.divide(
            Bindings.multiply(weight, 703),
            Bindings.multiply(height, height)
    );

    @Override
    double calcBMI(){ return bmiNumberBinding.doubleValue(); }
}

class C_LowLevelBinding extends B_BindingsUtilityClass {
    //
    private DoubleBinding bmiDoubleBinding = new DoubleBinding() {
        // Define dependencies
        { super.bind(weight, height); }
        @Override
        protected double computeValue() {
            return weight.get() * 703 / (height.get() * height.get());
        }
    };  // ATTENTION: ";" needed here, because it is an anonymous class

    @Override
    double calcBMI() {return bmiDoubleBinding.doubleValue();}
}



