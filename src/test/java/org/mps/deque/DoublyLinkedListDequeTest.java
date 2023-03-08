package org.mps.deque;

import org.junit.jupiter.api.*;
import org.mps.deque.DoublyLinkedListDeque;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("A DoublyLinkedListDeque")
class DoublyLinkedListDequeTest {

    @DisplayName("integer type")
    static
    class doublyLinkedListDequeInteger {
        DoublyLinkedListDeque<Integer> doublyLinkedListDeque;

        @Test
        @DisplayName("is instantiated with new DoublyLinkedListDeque()")
        void isInstantiatedWithNew(){
            new DoublyLinkedListDeque<>();
        }

        @Nested
        @DisplayName("when new")
        class WhenNew {

            @BeforeEach
            void createNewDoublyLinkedListDeque() {
                doublyLinkedListDeque = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("is empty")
            void isEmpty(){
                assertTrue(doublyLinkedListDeque.size() == 0);
            }

            @Nested
            @DisplayName("after prepend an element")
            @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
            class AfterPrepend{

                Integer value = 1;

                @BeforeEach
                void prependAnElement(){
                    doublyLinkedListDeque.prepend(value);
                }

                @Order(1)
                @Test
                @DisplayName("it is no longer empty")
                void isNotEmpty(){
                    boolean actualValue = doublyLinkedListDeque.size() > 0;
                    boolean expectedValue = true;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Order(2)
                @Test
                @DisplayName("when size equals 1, the element is the element is the first and the last")
                void sizeOneIsTheFirst(){
                    boolean actualValue;
                    boolean expectedValue = true;

                    actualValue = (doublyLinkedListDeque.first() == doublyLinkedListDeque.last());

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

            }

            @Nested
            @DisplayName("after append an element")
            @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
            class AfterAppend{

                Integer value = 1;

                @BeforeEach
                void appendAnElement(){
                    doublyLinkedListDeque.append(value);
                }

                @Order(1)
                @Test
                @DisplayName("it is no longer empty")
                void isNotEmpty(){
                    boolean actualValue = doublyLinkedListDeque.size() > 0;
                    boolean expectedValue = true;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Order(2)
                @Test
                @DisplayName("when size equals 1, the element is the element is the first and the last")
                void sizeOneIsTheFirst(){
                    boolean actualValue;
                    boolean expectedValue = true;

                    actualValue = (doublyLinkedListDeque.first() == doublyLinkedListDeque.last());

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("get elements")
            class getElements{

                Integer value = 1;

                @BeforeEach
                void prependAnElement(){
                    doublyLinkedListDeque.prepend(value);
                }

                @Test
                @DisplayName("the first element is correct")
                void getTheFirstElemente(){
                    Integer actualValue = doublyLinkedListDeque.first();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Test
                @DisplayName("the last element is correct")
                void getTheLastElemente(){
                    Integer actualValue = doublyLinkedListDeque.last();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("delete first element")
            class deleteFirst{

                Integer value = 1;

                @BeforeEach
                void prependAnElement(){
                    doublyLinkedListDeque.prepend(value);
                }

                @Test
                @DisplayName("just one element in the structure deleted, size equals zero")
                void deleteTheFirstAndOnlyElement(){
                    Integer actualValue;
                    Integer expectedValue = 0;

                    doublyLinkedListDeque.deleteFirst();
                    actualValue = doublyLinkedListDeque.size();

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Test
                @DisplayName("more than one element, reduce the size correctly")
                void deleteFirstMoreThanOneElement(){
                    doublyLinkedListDeque.prepend(2);
                    doublyLinkedListDeque.prepend(3);
                    doublyLinkedListDeque.prepend(4);

                    Integer actualValue;
                    Integer expectedValue = 3;

                    doublyLinkedListDeque.deleteFirst();
                    actualValue = doublyLinkedListDeque.size();

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("delete last element")
            class deleteLast{

                Integer value = 1;

                @BeforeEach
                void prependAnElement(){
                    doublyLinkedListDeque.prepend(value);
                }

                @Test
                @DisplayName("just one element in the structure deleted, size equals zero")
                void deleteTheLastAndOnlyElement(){
                    Integer actualValue;
                    Integer expectedValue = 0;

                    doublyLinkedListDeque.deleteLast();
                    actualValue = doublyLinkedListDeque.size();

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Test
                @DisplayName("more than one element, reduce the size correctly")
                void deleteFirstMoreThanOneElement(){
                    doublyLinkedListDeque.prepend(2);
                    doublyLinkedListDeque.prepend(3);
                    doublyLinkedListDeque.prepend(4);

                    Integer actualValue;
                    Integer expectedValue = 3;

                    doublyLinkedListDeque.deleteLast();
                    actualValue = doublyLinkedListDeque.size();

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("check different sizes")
            class size{

                @Test
                @DisplayName("if is empty, size equals 0")
                void isEmptySizeEqualsZero(){
                    doublyLinkedListDeque = new DoublyLinkedListDeque<>();
                    Integer actualValue = doublyLinkedListDeque.size();
                    Integer expectedValue = 0;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Test
                @DisplayName("if there is one element, size equals 1")
                void oneElementSizeEqualsOne(){
                    doublyLinkedListDeque = new DoublyLinkedListDeque<>();
                    doublyLinkedListDeque.append(1);
                    Integer actualValue = doublyLinkedListDeque.size();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

            }

        }
    }
}