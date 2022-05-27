/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CategoryDAO;
import entity.Category;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Musa
 */
@FacesConverter("categoryConverter")
public class CategoryConverter  implements Converter{
private CategoryDAO categoryDao;
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
       int id=Integer.valueOf(string);
       Category c=this.getCategoryDao().findByID(id);
return c;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
      Category c=(Category)t;
      return String.valueOf(c.getId());// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public CategoryDAO getCategoryDao() {
        if(categoryDao==null){
            this.categoryDao=new CategoryDAO();
        }
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }
    
    
}
