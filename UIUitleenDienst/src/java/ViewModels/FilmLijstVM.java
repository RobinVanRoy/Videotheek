/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import DAL.Film;
import java.util.List;

/**
 *
 * @author Ikke
 */
public class FilmLijstVM {
    
    private List<Film> filmLijst;

    public FilmLijstVM(List<Film> films) {
        this.filmLijst = films;
    }
    
    public List<Film> getFilms(){
        return filmLijst;
    }
    
    public void setFilms(List<Film> films){
        this.filmLijst = films;
    }
}
