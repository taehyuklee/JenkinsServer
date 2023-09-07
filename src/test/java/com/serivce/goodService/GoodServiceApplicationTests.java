package com.serivce.goodService;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
// import org.springframework.boot.test.context.SpringBootTest;

import com.serivce.goodService.first_service.service.GoodService;
import com.serivce.goodService.first_service.utility.GoodUtility;

// @SpringBootTest
class GoodServiceApplicationTests {

    // static MockedStatic<GoodUtility> staticMocked;

    // @BeforeAll
    // public static void beforeAll(){
    //     staticMocked = mockStatic(GoodUtility.class);
    // }

	@Test
	void contextLoads() {
	}


    //Stubbing & verfiy test
    @Test
    public void mockTest(){

        List mockedList = mock(List.class);
        List mockedList2 = mock(List.class);

        //stubbing here using by when & then methods
        Mockito.when(mockedList.get(0)).thenReturn("first");
        Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        //System.out.println(mockedList.get(1));

        //I was wondering how it save above data in mockedList structure (want to know principle of it)

        //following prints "null". because get(100) was not stubbed anywhere
        System.out.println(mockedList.get(100));

        Mockito.verify(mockedList).get(0); //basically, verify method check how many mock object was called? (default is one time call)

    }

    @Test
    public void verfiyTest(){
        // System.out.println(anyInt()); /anyInt()는 아무때나 쓸수는 없다
        System.out.println("good_verfiy_Test");
    }

    @Test
    public void staticMocktio(){
        /*static method is belong to class, not in instance. so Mockito library need to make something like proxy class with dynamic proxy technique
        that is mockStatic()*/

         // 정적 메서드를 모의(mock)하는 방식
         try (MockedStatic<GoodUtility> staticMocked = mockStatic(GoodUtility.class)) {
            // 모의(mock) 객체를 사용하여 메서드 호출 결과를 설정합니다.
            String[] expectedResult = new String[] {"a", "b", "c"};
            staticMocked.when(() -> GoodUtility.parsingMethod(Mockito.anyString())).thenReturn(expectedResult);
        
            // 테스트 대상 코드에서 정적 메서드를 호출합니다.
            String[] actualResult = GoodUtility.parsingMethod("a b c");
        
            // 결과를 검증합니다.
            assertArrayEquals(expectedResult, actualResult);
        }

        /**
         * The used MockMaker SubclassByteBuddyMockMaker does not support the creation of static mocks
         * If you do not apply dependency of mockito-inline, you will meet above error message
         */
    }

    @Test
    public void test(){
        assertEquals("a", "a");
    }

}
