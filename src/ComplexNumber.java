import java.util.Objects;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object instanceof ComplexNumber) {
            ComplexNumber cn = (ComplexNumber) object;
            return (this.re == cn.getRe()) & (this.im == cn.getIm());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    public static void main(String [] args){
        ComplexNumber a = new ComplexNumber(1.5, 2);
        ComplexNumber b = new ComplexNumber(3.4, 3.2);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
    }

}
