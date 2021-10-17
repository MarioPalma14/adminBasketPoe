/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2labo_mpwt;


public class query_mpwt {
    //universidad==================================================================
    public String ingresar_univer(String univer){
        String Ingresar_uni = "INSERT INTO universidad (nombre) VALUES ('"+univer+"');";
        return Ingresar_uni;
    }
   
    public String mostrar_universidad(){
        String mostrar = "SELECT * FROM universidad;";
        return mostrar;
    }
    public String modificar_univer(int id, String nombre){
        String modi = "UPDATE universidad SET nombre = '"+nombre+"' "+
                      "WHERE id_universidad = "+id+";";
        return modi;
    }
    public String eliminar_universidad(int id){
        String eliminar = "DELETE FROM universidad WHERE id_universidad ="+id;
        return eliminar;
    }
    //equipos======================================================================
    public String equipos(){
       String equipo ="SELECT  * FROM equipo" ;
    return equipo;
   }
    public String ingresar_equipo(int codigo,String nombre){
        String agg_equipo = "INSERT INTO equipo (codigo,nombre) VALUES ("+codigo+",'"+nombre+"')";
        return agg_equipo;
    }
    public String eliminar_equipo(int codigo){
         String del_equipo = "DELETE FROM equipo WHERE codigo ="+codigo;
         return del_equipo;
    }
    public String actu_equipo(int codigo,String nombre){
         String actu_equipo = "UPDATE equipo SET nombre = '"+nombre+"' WHERE codigo ="+codigo;
         return actu_equipo;
    }
    //para cargar los jcombo=================================================
    public String cargar_univer(){
        String universidad = "SELECT nombre FROM universidad";
        return universidad;
    }
    public String cargar_equipo(){
        String universidad = "SELECT nombre FROM equipo";
        return universidad;
    }
    public String filtro_unv(int id_uni){
        String filtro = "SELECT jg.dui AS dui, jg.nombre AS nombre, jg.posicion AS posicion, jg.edad AS edad, jg.estatura AS estatura, jg.peso AS peso, un.nombre AS universidad, eq.nombre AS equipo FROM jugador jg\n" +
"                        JOIN universidad un ON un.id_universidad = jg.id_universidad\n" +
"                        JOIN equipo eq ON eq.codigo = jg.codigo\n" +
"                        WHERE un.id_universidad = "+id_uni;
        return filtro;
    }
    public String filtro_equipo(int codigo){
        String equipo = "SELECT jg.dui AS dui, jg.nombre AS nombre, jg.posicion AS posicion, jg.edad AS edad, jg.estatura AS estatura, jg.peso AS peso, un.nombre AS universidad, eq.nombre AS equipo FROM jugador jg\n" +
                        "JOIN universidad un ON un.id_universidad = jg.id_universidad\n" +
                        "JOIN equipo eq ON eq.codigo = jg.codigo\n" +
                        "WHERE eq.codigo = "+codigo+";";
        
        return equipo;
    }
    
    
    public String cargar_jugadores(){
        String filtro = "SELECT jg.dui AS dui, jg.nombre AS nombre, jg.posicion AS posicion, jg.edad AS edad, jg.estatura AS estatura, jg.peso AS peso, un.nombre AS universidad, eq.nombre AS equipo FROM jugador jg\n" +
"                        JOIN universidad un ON un.id_universidad = jg.id_universidad\n" +
"                        JOIN equipo eq ON eq.codigo = jg.codigo\n"+";";
        return filtro;
    }
    public String agg_jugador(String dui, String nombre, String posicion, int edad, String estatura, String peso,
                              int id_universidad, int codigo){
        String jugador = "INSERT INTO jugador (dui,nombre,posicion,edad,estatura,peso,id_universidad,codigo)\n" +
                         "VALUES('"+dui+"','"+nombre+"','"+posicion+"',"+edad+",'"+estatura+"','"+peso+"',"+id_universidad+","+codigo+");";
        
        return jugador;
    }
    public String actu_jugador(String dui,String nombre, String posicion, int edad, String estatura, String peso,
                              int id_universidad, int codigo){
        String jugador = "UPDATE jugador SET nombre = '"+nombre+"',posicion = '"+posicion+"',edad ="+edad+",estatura = '"+estatura+"', peso = '"+peso+"',"
                       + "id_universidad = "+id_universidad+", codigo = "+codigo+" WHERE dui ='"+dui+"';";
        return jugador;
    }
    public String elim_jugador(String dui){
        String eliminar = "DELETE FROM jugador WHERE dui = '"+dui+"';";
        return eliminar;
    }
    
    public String cant_jugadores_equ(int cod){
        String consult = "SELECT COUNT(jb.dui) AS conteo FROM jugador jb\n" +
                         "JOIN equipo eq ON eq.codigo = jb.codigo\n" +
                         "WHERE eq.codigo = "+cod;
        return consult;
    }
    public String equipos_oficiales(){
        String equipos = "SELECT eq.codigo, eq.nombre, COUNT(jg.dui) AS jugadores FROM equipo eq\n" +
                         "JOIN jugador jg ON jg.codigo = eq.codigo\n" +
                         "GROUP BY eq.codigo, eq.nombre\n" +
                         "HAVING jugadores > 4 ";
        return equipos;
    }
    
    public String filtro_posi(String pos, int cod){
        String posicion = "SELECT COUNT(posicion) AS conteo FROM jugador jg " +
                          "JOIN equipo eq ON eq.codigo = jg.codigo " +
                          "WHERE eq.codigo = "+cod+" AND jg.posicion = '"+pos+"' OR jg.posicion = '"+pos+"';";
        return posicion;
    }
    
    public String get_dui(String pos, int codigo){
        String dui = "SELECT jg.dui FROM jugador jg\n" +
                     "JOIN equipo eq ON eq.codigo = jg.codigo\n" +
                     "WHERE jg.posicion = '"+pos+"' AND eq.codigo = "+codigo;
        return dui;
    }
}
