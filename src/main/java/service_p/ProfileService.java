package service_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ProfileService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
