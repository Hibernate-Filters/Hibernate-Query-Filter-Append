/**
 * 
 */
/**
 * @author Ankush.Verman
 *
 */

@FilterDef(name = "personfilter", defaultCondition = "defaultUser = :defaultUser", parameters = @ParamDef( name = "defaultUser", type = "string"))

package com.rudra.aks.filter.bo;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
