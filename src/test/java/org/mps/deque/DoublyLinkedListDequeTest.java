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
            @DisplayName("is empty the size equals 0")
            void isEmpty(){
                assertThat(doublyLinkedListDeque.size()).isEqualTo(0);
            }

            @Nested
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
                @DisplayName("when size equals 1, the element of the node is the first and the last")
                void sizeOneIsTheFirst(){
                    boolean actualValue;
                    boolean expectedValue = true;

                    actualValue = (doublyLinkedListDeque.first() == doublyLinkedListDeque.last());

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
                @DisplayName("when size equals 1, the element of the node is the first and the last")
                void sizeOneIsTheFirst(){
                    boolean actualValue;
                    boolean expectedValue = true;

                    actualValue = (doublyLinkedListDeque.first() == doublyLinkedListDeque.last());

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
                @DisplayName("when there are 2 nodes, the size is correct")
                void sizeOneIsTheFirst(){
                    Integer actualValue = doublyLinkedListDeque.size();
                    Integer expectedValue = 2;

                    assertThat(actualValue).isEqualTo(expectedValue);
                }

                @Order(3)
                @Test
                @DisplayName("prepending a new node, the size is incremented correctly")
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

            /*
            @Nested
            @DisplayName("deleting")
            class DeleteElement{

                @Nested
                @DisplayName("delete first element")
                class deleteFirst{

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
            }
            */

            @Nested
            @DisplayName("error cases")
            class ExceptionCases {
                @Test
                @DisplayName("deleting the first and, although, the size is zero")
                void ExceptionDeleteFirstWithNoNodes(){
                    assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.deleteFirst());
                }

                @Test
                @DisplayName("deleting the last and, although, the size is zero")
                void ExceptionDeleteLastWithNoNodes(){
                    assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.deleteLast());
                }

                @Test
                @DisplayName("getting the first element and, although, the size is zero")
                void ExceptionGettingFirstWithNoNodes(){
                    assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.first());
                }

                @Test
                @DisplayName("getting the last element and, although, the size is zero")
                void ExceptionGettingLastWithNoNodes(){
                    assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.last());
                }
            }

        }
    }
}