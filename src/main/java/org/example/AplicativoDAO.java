package org.example;

import java.util.List;

public interface AplicativoDAO {
    boolean createAplicativo (Aplicativo aplicativo);
    List<Aplicativo> read ();
    boolean update(Aplicativo aplicativo);
    boolean delete(Aplicativo aplicativo);
}
