package DAL;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-15T20:12:23")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, String> omschrijving;
    public static volatile SingularAttribute<Film, String> titel;
    public static volatile SingularAttribute<Film, Boolean> uitgeleend;
    public static volatile SingularAttribute<Film, Integer> filmID;
    public static volatile SingularAttribute<Film, String> genre;
    public static volatile SingularAttribute<Film, Integer> jaar;
    public static volatile SingularAttribute<Film, String> acteurs;

}