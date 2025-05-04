package OO2.Ejercicio17_Patrones_AccesoALaBaseDeDatos;

import java.util.Collection;
import java.util.List;

public interface DatabaseAccess {
    Collection<String> getSearchResults(String queryString);

    int insertNewRow(List<String> rowData);
}