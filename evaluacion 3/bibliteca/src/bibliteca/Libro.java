package bibliteca;

public class Libro {

    private String titulo;
    private String autor;
    private Genero genero;

    public Libro(String titulo, String autor, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               " | Autor: " + autor +
               " | Género: " + genero;
    }
}


	
	

