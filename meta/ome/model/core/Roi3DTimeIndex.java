package ome.model.core;

import ome.util.BaseModelUtils;


import java.util.*;




/**
 * Roi3DTimeIndex generated by hbm2java
 */
public class
Roi3DTimeIndex extends ome.model.core.Roi3D
implements java.io.Serializable ,
ome.api.OMEModel {

    // Fields    

     private Integer indexT;


    // Constructors

    /** default constructor */
    public Roi3DTimeIndex() {
    }
    
   
    
    

    // Property accessors

    /**
     * 
     */
    public Integer getIndexT() {
        return this.indexT;
    }
    
    public void setIndexT(Integer indexT) {
        this.indexT = indexT;
    }





	/** utility methods. Container may re-assign this. */	
	protected static BaseModelUtils _utils = 
		new BaseModelUtils();
	public BaseModelUtils getUtils(){
		return _utils;
	}
	public void setUtils(BaseModelUtils utils){
		_utils = utils;
	}



}
