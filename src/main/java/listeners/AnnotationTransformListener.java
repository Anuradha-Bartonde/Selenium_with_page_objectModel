package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformListener implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class arg1, Constructor constructor,
			Method method) {
		annotation.setRetryAnalyzer(RetryAnalyzerListener.class);
	}
}