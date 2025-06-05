package OO2.Parcial_2022_SegundaFecha;

public class PresionDecorator extends Decorator{

	@Override
	public String displayData() {
		return super.displayData() + this.getPresion();
	}

}
