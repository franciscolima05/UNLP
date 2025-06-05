package OO2.Parcial_2022_SegundaFecha;

public class MaximaDecorator extends Decorator{

	@Override
	public String displayData() {
		return super.displayData() + this.temperaturaMaxima();
	}

}
