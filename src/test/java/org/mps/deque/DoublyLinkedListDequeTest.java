package org.mps.deque;

import org.junit.jupiter.api.*;
import org.mps.deque.DoublyLinkedListDeque;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CASOS DE PRUEBA
 * 1. Pruebas del constructor de de SoublyLinkedListDeque -- 33 test
 *  1.1 Comprobar que se instancia como un nuevo objeto
 *  1.2 Ccomprobar que cuando se instancia como nuevo, el tamaño de la lista es 0
 *  1.3 Después de prependar y apendar un nodo -- 8 test
 *      1.3.1 Comprobar que cuando se crean dos nuevos nodos, no están vacíos
 *      1.3.2 Comprobar que el tamaño es correcto
 *      1.3.3 Comprobar que al prependar un nuevo nodo, el tamaño se incrementa correctamente
 *      1.3.4 Comprobar que al apendar un nuevo nodo, el tamaño se incrementa correctamente
 *      1.3.5 Comprobar que al borrar el último, el tamaño se decrementa correctamente
 *      1.3.6 Comprobar que al borrar el primero, el tamaño se decrementa correctamente
 *      1.3.7 Comprobar que el elemento del último nodo es correcto
 *      1.3.8 Comprobar que el elemento del primer nodo es correcto
 *  1.4 Después de apendar un nodo -- 8 test
 *      1.4.1 Comprobar que cuando se crea un nuevo nodo, no está vacío
 *      1.4.2 Comprobar que cuando en la lista hay un nodo, el primer y último elemento son el mismo
 *      1.4.3 Comprobar que al apendar un nuevo nodo valor vacío, se lanza una excepción
 *      1.4.4 Comprobar que cuando en la lista un nodo, el tamaño es correcto
 *      1.4.5 Comprobar que cuando se borra el último nodo, el tamaño es correcto
 *      1.4.6 Comprobar que cuando se borra el primer nodo, el tamaño es correcto
 *      1.4.7 Comprobar que el elemento del primer nodo es correcto
 *      1.4.8 Comprobar que el elemento del último nodo es correcto
 *  1.5 Después de prependar un nodo -- 8 test
 *      1.5.1 Comprobar que cuando se crea un nuevo nodo, no está vacío
 *      1.5.2 Comprobar que cuando en la lista hay un nodo, el primer y último elemento son el mismo
 *      1.5.3 Comprobar que al apendar un nuevo nodo valor vacío, se lanza una excepción
 *      1.5.4 Comprobar que cuando en la lista un nodo, el tamaño es correcto
 *      1.5.5 Comprobar que cuando se borra el último nodo, el tamaño es correcto
 *      1.5.6 Comprobar que cuando se borra el primer nodo, el tamaño es correcto
 *      1.5.7 Comprobar que el elemento del primer nodo es correcto
 *      1.5.8 Comprobar que el elemento del último nodo es correcto
 *  1.6 Casos de error -- 4 test
 *      1.6.1 Comprobar que cuando la lista está vacía e intentas obtener el elemento del último nodo, lanza una excepción
 *      1.6.2 Comprobar que cuando la lista está vacía e intentas borrar el último nodo, lanza una excepción
 *      1.6.3 Comprobar que cuando la lista está vacía e intentas obtener el elemento del primer nodo, lanza una excepción
 *      1.6.4 Comprobar que cuando la lista está vacía e intentas borrar el primer nodo, lanza una excepción
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