package patterns.servlet;


import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "Hello, <script> welcome to Alpha.com, we are all 996 ";
        Response response = new Response();
        response.str = "";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter()).add(new SensitiveFilter());
        chain.doFilter(request, response);

        System.out.println(request.str);
        System.out.println(response.str);

        System.out.println((-10 % 7));      // -3
        System.out.println((-10 / 7));      // -1
    }
}

interface Filter{
    boolean doFilter(Request request, Response reponse, FilterChain chain);
}

class FilterChain{

    int index = 0;
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter r){
        filters.add(r);
        return this;
    }

    public boolean doFilter(Request request, Response response) {

        if(index == filters.size()) return false;
        return filters.get(index++).doFilter(request, response, this);
    }
}

class HTMLFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + " - HTMLFilter";
        chain.doFilter(request, response);
        response.str += " -- HTMLFilter()";
        return true;
    }

}

class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response reponse, FilterChain chain) {
        request.str = request.str.replaceAll("996", "955") + " - SensitiveFilter";
        chain.doFilter(request, reponse);
        reponse.str += " -- SensitiveFilter()";
        return false;
    }
}

class Request{
    String str;
}

class Response{
    String str;
}