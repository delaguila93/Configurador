/**
 * @file    Util.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */
package com.tiendainformatica;


public class Util {
    
    
    /**
     * @brief Función para limpiar el parametro o devuelve un por defecto
     * @param param
     * @param defecto
     * @return El paramertro limpio o uno por defecto
     */
    public static String getParam(String param, String defecto) {        
        if (param!=null && !param.trim().equals(""))
            param=param.trim();
        else
            param=defecto;
        return param;
    }
    
    /**
     * @brief Función que comprueba si un parametro existe
     * @param param
     * @return True si el parametro existe, False si el parametro no existe
     */
    public static boolean getParamBool(String param) {
        boolean result=false;
        if (param!=null && !param.trim().equals(""))
            result=true;
        return result;
    }
    
}
