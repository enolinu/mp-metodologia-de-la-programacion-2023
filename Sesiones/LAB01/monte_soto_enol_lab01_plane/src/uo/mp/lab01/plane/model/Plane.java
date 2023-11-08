package uo.mp.lab01.plane.model;
/**
 * Clase Plane 
 */
public class Plane
{
    public static final char DEFAULT_IDENTIFIER = 'A';
    public static final int DEFAULT_FUEL = 0;
    public static final int MIN_FUEL = 0;
    
    public static final char MIN_IDENTIFIER = 'A';
    public static final char MAX_IDENTIFIER = 'Z';
          
    private Person pilot;       // piloto del avi�n
    private char identifier;    // Identificaci�n del avi�n, una letra may�scula
    private int fuel;           // cantidad actual de combustible que lleva el avi�n >= 0

    /**
     * Constructor sin par�metros
     */
    public Plane()
    {
       setIdentifier(DEFAULT_IDENTIFIER);
       setFuel(DEFAULT_FUEL);
    }
    
     /**
     * Constructor con tres parametros
     */
    public Plane (Person pilot, char identifier, int fuel)
    {
       this();
       setPilot(pilot);
       setIdentifier(identifier);
       setFuel(fuel);
    }
    
    /**
     * Modifica el piloto del avi�n
     * 
     * @param pilot el piloto asignado al avi�n
     * 
     */   
    private void setPilot(Person pilot)
    {
    	// permitiremos que no haya piloto (pilot == null)
        this.pilot = pilot;
    }
    
    /**
     * Modifica el dentificador del avi�n
     *
     * @param identifier el nuevo identificador para el avi�n
     */
    private void setIdentifier(char identifier)
    {
    	checkParam(identifier >= MIN_IDENTIFIER && identifier <= MAX_IDENTIFIER,
    			   "Identificador fuera de l�mites");
        this.identifier = identifier;
    }
    
    /**
     * Modifica el fuel del avi�n
     * 
     * @param fuel cantidad de compustible para el avi�n
     */
    private void setFuel(int fuel)
    {
    	checkParam(fuel >= MIN_FUEL, "Valor del combustible por debajo del l�mite");
        this.fuel = fuel;
    }
    
    /**
     * Devuelve el piloto del avi�n
     * 
     * @return  el piloto del avi�n 
     */
    public Person getPilot()
    {
        return pilot;
    }
    
    /**
     * Devuelve el identificador del avi�n
     * 
     * @return  el identificador del avi�n
     */
    public char getIdentifier()
    {        
        return identifier;
    }

    /**
     * Devuelve el fuel del avi�n
     * 
     * @return  el combustible del avi�n
     */
    public int getFuel()
    {
         return fuel;
    }
    
    /**
     * Devuelve una cadena con el valor de las propiedades del avi�n
     * 
     * @return   una cadena con el valor de las propiedades del avi�n 
     */
    public String toString()
    {
    	 	
    	String stringToReturn = String.format("Identificador: %2s Combustible: % 3d Piloto: %10s", 
    			                                getIdentifier(), getFuel(), getPilotToString());
             
        return  stringToReturn;
    }
    
    /**
     * Convierte los datos del piloto a string si existen o NO PILOT 
     * si no hay piloto
     * @return datos del piloto
     */
    private String getPilotToString() {
    	if ( getPilot() == null)
            return " NO PILOT";
       else
            return getPilot().toString();
    }
    
   
	/**
     * Devuelve false si no hay SUFICIENTE combustible, 
	 * si lo hay reduce el combustible en 1 unidad y devuelve true
	 
     * @return true si hay combustible y false si no tiene combustible
     */
    public boolean fly()
    {
        if (getFuel() == MIN_FUEL)
            return false;
        else
        {
            setFuel(getFuel() - 1);
            return true;
        }
    }    
       
    /**
	 * Control de par�metros. Lanza excepci�n si no se cumple la condici�n recibida y env�a el 
	 * mensaje recibido
	 * @param condition
	 * @param msg
	 */
	private void checkParam(boolean condition, String msg) {
		if (! condition) {
			throw new IllegalArgumentException(msg);
		}		
	}
}
