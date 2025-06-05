package OO2.Parcial_2022_SegundaFecha;

public class TemperaturaDecorator extends Decorator{

	@Override
	public String displayData() {
		return super.displayData() + this.getTemperatura();
	}


}
