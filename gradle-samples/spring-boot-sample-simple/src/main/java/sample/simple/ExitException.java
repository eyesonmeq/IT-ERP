package sample.simple;

import org.springframework.boot.ExitCodeGenerator;

public class ExitException extends RuntimeException implements ExitCodeGenerator {

	private static final long serialVersionUID = 8358829093628638202L;

	@Override
	public int getExitCode() {
		return 10;
	}

}
