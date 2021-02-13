package com.mx.cesar.utilities;

import java.util.regex.Pattern;

public class LimpiaCadenas {


	/**
	 *Quita espacios de más que estén en medio(lo deja en un solo espacio)
      Quita espacios al inicio y al final
      Convierte a mayúsculas
	 * @param texto
	 * @return
	 */
    public static final String limpiaCadena(String texto){
        return texto.replaceAll("\\s+", " ").trim().toUpperCase();
    }
    
	/**
	 * Quita espacios de más que estén en medio (lo deja en un solo espacio)
	 * Quita espacios al inicio y al final
	 */
    public static final String limpiaNombresPersonas(String nombre) {
    	return nombre.replaceAll("\\s+", " ").trim();
    }
    
    /**
     * Quita espacios al principio y al final
     * @param texto
     * @return
     */
    public static final String quitaEspaciosPrincipioYFinal(String texto) {
    	
    	return texto.trim();
    }
    
    /**
     * Quita TODOS los espacios (al principio, en medio y al final)
     * @param cadena
     * @return
     */
    public static final String quitaTodosEspacios(String cadena) {
    	return cadena.replaceAll("\\s+", "").replaceAll("\\s","").trim();
    }
    
    public static final String quitaEspaciosConvierteMayusculas(String texto) {
    	return texto.trim().toUpperCase();
    }
    
    public static final String quitaEspaciosConvierteMinusculas(String texto) {
    	return texto.trim().toLowerCase();
    }
    
    /**
     * Permite sólo números
     * @param cadena
     * @return
     */
    public static final boolean soloNumeros(String cadena) {
    	String soloNumerosPatron = "[0123456789]*";
    	return Pattern.matches(soloNumerosPatron, cadena);
    }
    
    /**
     * Permite saber si el tamaño de un campo se ajusta a los límites establecidos
     * @param limiteInferior
     * @param limiteSuperior
     * @return
     */
    public static final boolean longitudesCadenas(int limiteInferior, int limiteSuperior, String cadena) {
        if ((cadena.length() < limiteInferior) || (cadena.length() > limiteSuperior)) {
            return false;
        }      
        return true;
    }
    
    /**
     * Verifica si la cadena contiene el número exacto de carácteres
     * @param longitudExacta
     * @param cadena
     * @return
     */
	public static final boolean validarLongitudExacta(int longitudExacta, String cadena) {
		if(cadena.length() != longitudExacta) {
			return false;
		}
		return true;		
	}
	
	/**
	 * Valida que la cadena contenga solo letras (mayúsculas y minúsculas), espacios y números
	 * @param cadena
	 * @return
	 */
	public static final boolean validaNumerosLetrasMayusculasMinusculasEspacios(String cadena) {	
		String patron = "[0123456789áéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ\\s]*";
		return Pattern.matches(patron, cadena);
	}
	
	/**
	 * Permite letras mayúsculas, minúsculas, con acentos, espacios, números y algunos caracteres "raros"
	 * @param cadena
	 * @return
	 */
	public static final boolean validaCadenaLetrasMayusculasMinusculasConAcentosNumerosEspaciosAlgunosCaracteresRaros(String cadena) {	
		String patron = "[&_-.0123456789!¡?¿#\"+@áéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ\\s]*";
		return Pattern.matches(patron, cadena);
	}
	
	/**
	 * Valida letras (mayusculas, minusculas) con acentos, con dierecis, espacios y puntos
	 * @param cadena
	 * @return
	 */
	public static final boolean validaCadenasLetrasConAcentosEspaciosYPuntos(String cadena) {	
		String patron = "[.üäáéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ\\s]*";
		return Pattern.matches(patron, cadena);
	}
	
	/**
	 * Permite números, letras mayúsculas, minúsculas, con acentos, espacios y puntos
	 * @param cadena
	 * @return
	 */
	public static final boolean validaNumerosLetrasMayusculasMinusculasEspaciosPuntos(String cadena) {	
		String patron = "[.0123456789áéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ\\s]*";
		return Pattern.matches(patron, cadena);
	}
}





