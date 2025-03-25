package doaltoBienvenido;

public class Tablero {
    private char[][] casillas;
    private final char CASILLA_VACIA = '_';

    public Tablero() {
        casillas = new char[3][3];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = CASILLA_VACIA;
            }
        }
    }

    public void mostrar() {
        limpiarPantalla();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(" " + casillas[i][j]);
            }
            System.out.println();
        }
    }

    private void limpiarPantalla() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        for (int i = 0; i < 3; i++) {
            if (casillas[i][0] == color && casillas[i][1] == color && casillas[i][2] == color
                && casillas[i][0] != CASILLA_VACIA) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (casillas[0][j] == color && casillas[1][j] == color && casillas[2][j] == color
                && casillas[0][j] != CASILLA_VACIA) {
                return true;
            }
        }

        if (casillas[0][0] == color && casillas[1][1] == color && casillas[2][2] == color
            && casillas[0][0] != CASILLA_VACIA) {
            return true;
        }

        if (casillas[0][2] == color && casillas[1][1] == color && casillas[2][0] == color
            && casillas[0][2] != CASILLA_VACIA) {
            return true;
        }

        return false;
    }

    public boolean estaCompleto(Jugador jugador) {
        int conteoFichas = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == jugador.colorDeFicha()) {
                    conteoFichas++;
                }
            }
        }
        return conteoFichas == 3;
    }

    public boolean estaOcupado(Coordenada coordenada) {
        return casillas[coordenada.fila()][coordenada.columna()] != CASILLA_VACIA;
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        if (!estaOcupado(coordenada)) {
            casillas[coordenada.fila()][coordenada.columna()] = color;
        }
    }

    public void sacarFicha(Coordenada coordenada) {
        casillas[coordenada.fila()][coordenada.columna()] = CASILLA_VACIA;
    }

    public boolean estaVacio(Coordenada coordenada) {
        return !estaOcupado(coordenada);
    }

}
