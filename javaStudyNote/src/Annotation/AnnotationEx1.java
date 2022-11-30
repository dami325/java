package Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101",hhmmss="235959"))
public class AnnotationEx1 {

	public static void main(String[] args) {
		// AnnotationEx5의 Class객체를 얻는다.
		Class<AnnotationEx1> cls = AnnotationEx1.class;
		
		// 클래스 객체가 가지고 있는 getAnnotation()
		TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
		// 정보를 얻고자 하는 애너테이션 지정
		System.out.println(anno.testedBy());
		
		
		System.out.println(anno.testDate().yymmdd());
		System.out.println(anno.testDate().hhmmss());
		for(String str : anno.testTools()) {
			System.out.println("testTools=" + str);
		}
		System.out.println();
		
		// AnnotationEx1에 적용된 모든 애너테이션을 가져온다.
		Annotation[] annoArr = cls.getAnnotations();
		
		for(Annotation a : annoArr)
			System.out.println(a);
		
	}

}


@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용가능하도록 지정
@interface TestInfo{
	int count()				default 1;
	String testedBy();
	String[] testTools() 	default "JUnit";
	TestType testType()  	default TestType.FIRST;
	DateTime testDate();
	
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
	String yymmdd();
	String hhmmss();
}

enum TestType { FIRST, FINAL }
