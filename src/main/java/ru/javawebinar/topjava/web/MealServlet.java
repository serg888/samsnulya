package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.TempInitialMeal;
import ru.javawebinar.topjava.storage.MapStorage;
import ru.javawebinar.topjava.storage.Storage;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.ThreadSafeCounter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * Created by Сергей on 17.01.2017.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);
    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = new MapStorage();
        storage.add(TempInitialMeal.get());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //говорим, что можем принимать русские буквы с кодировкой UTF-8
        String id=request.getParameter("id");
        String dateTime=request.getParameter("datetime");
        String description=request.getParameter("description");
        String calorii=request.getParameter("cal");
        Meal meal=new Meal(Long.parseLong(id), LocalDateTime.parse(dateTime),description,Integer.parseInt(calorii));
        storage.update(Long.parseLong(id),meal);
        request.setAttribute("mealsList", MealsUtil.getFilteredWithExceed(storage.getAll(), 2000));
        request.getRequestDispatcher("/jsp/mealList.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("mealsList", MealsUtil.getFilteredWithExceed(storage.getAll(), 2000));
            request.getRequestDispatcher("/jsp/mealList.jsp").forward(request, response);
        }

        switch(action){
            case "delete":
                storage.delete(Long.parseLong(id));
                response.sendRedirect("/meals");
                break;
            case "new":
                Meal newMeal=new Meal(LocalDateTime.now(),"",0);
                request.setAttribute("meal",newMeal);
                request.getRequestDispatcher("jsp/editMeal.jsp").forward(request,response);
                break;
            case "edit":
                Meal meal=storage.get(Long.parseLong(id));
                request.setAttribute("meal",meal);
                request.getRequestDispatcher("jsp/editMeal.jsp").forward(request,response);
                break;


        }
    }
}
