package org.mps.deque;

import org.junit.jupiter.api.*;
import org.mps.deque.DoublyLinkedListDeque;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CASOS DE PRUEBA
 */

@DisplayName("A DoublyLinkedListDeque")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> doublyLinkedListDeque;

    @Test
    @Order(1)
    @DisplayName("is instantiated with new DoublyLinkedListDeque()")
    void isInstantiatedWithNew(){
        new DoublyLinkedListDeque<>();
    }

    @Nested
    @Order(2)
    @DisplayName("when new")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class WhenNew {

        @BeforeEach
        void createNewDoublyLinkedListDeque() {
            doublyLinkedListDeque = new DoublyLinkedListDeque<>();
        }

        @Test
        @Order(1)
        @DisplayName("is empty the size equals 0")
        void isEmpty(){
            assertThat(doublyLinkedListDeque.size()).isEqualTo(0);
        }

        @Nested
        @Order(2)
        @DisplayName("error cases")
        class ExceptionCases {
            @Test
            @DisplayName("deleting the first, it throws an exception")
            void ExceptionDeleteFirstWithNoNodes(){
                assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.deleteFirst());
            }

            @Test
            @DisplayName("deleting the last, it throws an exception")
            void ExceptionDeleteLastWithNoNodes(){
                assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.deleteLast());
            }

            @Test
            @DisplayName("getting the first element, it throws an exception")
            void ExceptionGettingFirstWithNoNodes(){
                assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.first());
            }

            @Test
            @DisplayName("getting the last element, it throws an exception")
            void ExceptionGettingLastWithNoNodes(){
                assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.last());
            }
        }

        @Nested
        @Order(3)
        @DisplayName("after prepending a node")
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
            @DisplayName("the element of the node is the first and the last")
            void sizeOneIsTheFirst(){
                boolean actualValue;
                boolean expectedValue = true;

                actualValue = (doublyLinkedListDeque.first().equals(doublyLinkedListDeque.last()));

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Order(3)
            @Test
            @DisplayName("when prepend value equals null, throw an exception")
            void nullValue(){
                assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.prepend(null));
            }

            @Order(4)
            @Test
            @DisplayName("the size equals 1")
            void oneElementSizeEqualsOne(){
                Integer actualValue = doublyLinkedListDeque.size();
                Integer expectedValue = 1;

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Nested
            @DisplayName("get elements")
            class getElements{

                @Test
                @DisplayName("the first element is correct")
                void getTheFirstElement(){
                    Integer actualValue = doublyLinkedListDeque.first();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Test
                @DisplayName("the last element is correct")
                void getTheLastElement(){
                    Integer actualValue = doublyLinkedListDeque.last();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("after deleting")
            class DeleteElement{

                @Nested
                @DisplayName("the first node")
                class DeleteFirstNode{

                    @BeforeEach
                    void deleteFirst(){
                        doublyLinkedListDeque.deleteFirst();
                    }

                    @Test
                    @DisplayName("the size equals 0")
                    void deleteTheFirstAndOnlyElement(){
                        Integer actualValue = doublyLinkedListDeque.size();
                        Integer expectedValue = 0;

                        assertThat(actualValue).isEqualTo(expectedValue);
                    }
                }

                @Nested
                @DisplayName("the last node")
                class DeleteLastNode{

                    @BeforeEach
                    void deleteLast(){
                        doublyLinkedListDeque.deleteLast();
                    }

                    @Test
                    @DisplayName("the size equals 0")
                    void deleteTheLastAndOnlyElement(){
                        Integer actualValue = doublyLinkedListDeque.size();
                        Integer expectedValue = 0;

                        assertThat(actualValue).isEqualTo(expectedValue);
                    }
                }

            }
        }

        @Nested
        @Order(4)
        @DisplayName("after appending a node")
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
            @DisplayName("the element of the node is the first and the last")
            void sizeOneIsTheFirst(){
                boolean actualValue;
                boolean expectedValue = true;

                actualValue = (doublyLinkedListDeque.first().equals(doublyLinkedListDeque.last()));

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Order(3)
            @Test
            @DisplayName("when append value equals null, throw an exception")
            void nullValue(){
                assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.append(null));
            }

            @Order(4)
            @Test
            @DisplayName("the size equals 1")
            void oneElementSizeEqualsOne(){
                Integer actualValue = doublyLinkedListDeque.size();
                Integer expectedValue = 1;

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Nested
            @DisplayName("get elements")
            class getElements{

                @Test
                @DisplayName("the first element is correct")
                void getTheFirstElement(){
                    Integer actualValue = doublyLinkedListDeque.first();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Test
                @DisplayName("the last element is correct")
                void getTheLastElement(){
                    Integer actualValue = doublyLinkedListDeque.last();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("after deleting")
            class DeleteElement{

                @Nested
                @DisplayName("the first node")
                class DeleteFirstNode{

                    @BeforeEach
                    void deleteFirst(){
                        doublyLinkedListDeque.deleteFirst();
                    }

                    @Test
                    @DisplayName("the size equals 0")
                    void deleteTheFirstAndOnlyElement(){
                        Integer actualValue = doublyLinkedListDeque.size();
                        Integer expectedValue = 0;

                        assertThat(actualValue).isEqualTo(expectedValue);
                    }
                }

                @Nested
                @DisplayName("the last node")
                class DeleteLastNode{

                    @BeforeEach
                    void deleteLast(){
                        doublyLinkedListDeque.deleteLast();
                    }

                    @Test
                    @DisplayName("the size equals 0")
                    void deleteTheLastAndOnlyElement(){
                        Integer actualValue = doublyLinkedListDeque.size();
                        Integer expectedValue = 0;

                        assertThat(actualValue).isEqualTo(expectedValue);
                    }
                }

            }
        }

        @Nested
        @Order(5)
        @DisplayName("after prepending and appending a node")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class AfterAppendingAndPrepending{
            Integer value1 = 1;
            Integer value2 = 2;

            @BeforeEach
            void prependAnElement(){
                doublyLinkedListDeque.prepend(value1);
                doublyLinkedListDeque.append(value2);
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
            @DisplayName("the size is correct")
            void sizeOneIsTheFirst(){
                Integer actualValue = doublyLinkedListDeque.size();
                Integer expectedValue = 2;

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Order(3)
            @Test
            @DisplayName("when prepending a new node, the size is incremented correctly")
            void prepending(){
                doublyLinkedListDeque.prepend(3);
                Integer actualValue = doublyLinkedListDeque.size();
                Integer expectedValue = 3;

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Order(4)
            @Test
            @DisplayName("when appending a new node, the size is incremented correctly")
            void appending(){
                doublyLinkedListDeque.append(3);
                Integer actualValue = doublyLinkedListDeque.size();
                Integer expectedValue = 3;

                assertThat(actualValue).isEqualTo(expectedValue);
            }

            @Nested
            @DisplayName("get elements")
            class getElements{

                @Test
                @DisplayName("the first element is correct")
                void getTheFirstElement(){
                    Integer actualValue = doublyLinkedListDeque.first();
                    Integer expectedValue = 1;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }


                @Test
                @DisplayName("the last element is correct")
                void getTheLastElement(){
                    Integer actualValue = doublyLinkedListDeque.last();
                    Integer expectedValue = 2;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }
            }

            @Nested
            @DisplayName("after deleting")
            class DeleteElement{

                @Nested
                @DisplayName("the first node")
                class DeleteFirstNode{

                    @BeforeEach
                    void deleteFirst(){
                        doublyLinkedListDeque.deleteFirst();
                    }

                    @Test
                    @DisplayName("the size equals 1")
                    void deleteTheFirstAndOnlyElement(){
                        Integer actualValue = doublyLinkedListDeque.size();
                        Integer expectedValue = 1;

                        assertThat(actualValue).isEqualTo(expectedValue);
                    }
                }

                @Nested
                @DisplayName("the last node")
                class DeleteLastNode{

                    @BeforeEach
                    void deleteLast(){
                        doublyLinkedListDeque.deleteLast();
                    }

                    @Test
                    @DisplayName("the size equals 1")
                    void deleteTheLastAndOnlyElement(){
                        Integer actualValue = doublyLinkedListDeque.size();
                        Integer expectedValue = 1;

                        assertThat(actualValue).isEqualTo(expectedValue);
                    }
                }
            }
        }
    }
}