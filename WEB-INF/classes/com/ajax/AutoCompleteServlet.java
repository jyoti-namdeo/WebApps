package com.ajax;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;

public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
    private ComposerData compData = new ComposerData();
    private HashMap composers = compData.getComposers();

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {

                Iterator it = composers.keySet().iterator();

                while (it.hasNext()) {
                    String id = (String) it.next();
                    Composer composer = (Composer) composers.get(id);

                    if ( // targetId matches first name
                         composer.getFirstName().toLowerCase().startsWith(targetId.toLowerCase()) ||
                         // targetId matches last name
                         composer.getLastName().toLowerCase().startsWith(targetId.toLowerCase()) ||
						 composer.getLastName().toLowerCase().contains(targetId.toLowerCase()) )
                         // targetId matches full name
                         //composer.getFirstName().toLowerCase().concat(" ")
                           // .concat(composer.getLastName().toLowerCase()).startsWith(targetId)) 
						   {

                        sb.append("<composer>");
                        sb.append("<id>" + composer.getId() + "</id>");
                        sb.append("<firstName>" + composer.getFirstName() + "</firstName>");
                        sb.append("<lastName>" + composer.getLastName() + "</lastName>");
                        sb.append("</composer>");
                        namesAdded = true;
                    }
                }
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {

            // put the target composer in the request scope to display 
			System.out.println("Target id is :"+targetId);
            if ((targetId != null) && composers.containsKey(targetId.trim())) {
                request.setAttribute("composer", composers.get(targetId));
				int tID = Integer.parseInt(targetId);
				if(tID>=100 && tID<200){
					context.getRequestDispatcher("/PizzaServlet").forward(request, response);
				}
				else if(tID>=200 && tID<300){
					context.getRequestDispatcher("/BreadServlet").forward(request, response);
				}
				else if(tID>=300 && tID<400){
					context.getRequestDispatcher("/DesertsServlet").forward(request, response);
				}
				else if(tID>=400 && tID<500){
					context.getRequestDispatcher("/DrinksServlet").forward(request, response);
				}
				
            }
        }
    }
}
