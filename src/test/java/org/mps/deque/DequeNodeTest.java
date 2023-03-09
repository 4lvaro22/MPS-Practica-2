package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * CASOS DE PRUEBA
 * 1. Pruebas del constructor DequeNode -- 8 test
 *  1.1. Prueba del constructor con todos los parametros nulos
 *  1.2. Prueba del constructor con el nodo previo no nulo y el elemento y el nodo posterior nulos
 *  1.3. Prueba del constructor con el nodo posterior no nulo y el elemento y el nodo previo nulos
 *  1.4. Prueba del constructor con el nodo posterior y previo y el elemento nulo
 *  1.5. Prueba del constructor con el elemento no nulo y el nodo previo y el nodo posterior nulos
 *  1.6. Prueba del constructor con el elemento y el nodo previo no nulo y el nodo posterior nulo
 *  1.7. Prueba del constructor con el elemento y el nodo posterior no nulo y el nodo previo nulos
 *  1.8. Prueba del constructor con el nodo posterior, el nodo previo y elemento no nulo
 *
 * 2. Comprobar que devuelve el item correcto (Sin haber añadido un elemento, después de añadirlo, después de añadir un nodo previo, un nodo posterior, un nodo previo y posterior) -- 5 test
 * 3. Comprobar que establece el elemento correcto a un nodo (Se comprueba con el metodo getItem()) -- 1 test (Incluido en el anterior caso)
 * 4. Comprobar que devuelve el nodo previo correcto (Sin haber añadido un elemento, después de añadirlo, después de añadir un nodo previo, un nodo posterior, un nodo previo y posterior) -- 5 test
 * 3. Comprobar que establece el nodo previo correcto a un nodo (Se comprueba con el metodo getPrevious()) -- 2 test (Incluido en el anterior caso)
 * 5. Comprobar que devuelve el nodo posterior correcto (Sin haber añadido un elemento, después de añadirlo, después de añadir un nodo previo, un nodo posterior, un nodo previo y posterior) -- 5 test
 * 6. Comprobar que establece el nodo posterior correcto a un nodo (Se comprueba con el metodo getNext()) -- 2 test (Incluido en el anterior caso)
 * 7. Comprobar que es el primer nodo (Sin haber añadido un elemento, después de añadirlo, después de añadir un nodo previo, un nodo posterior, un nodo previo y posterior) -- 5 test
 * 8. Comprobar que es el último elemento (Sin haber añadido un elemento, después de añadirlo, después de añadir un nodo previo, un nodo posterior, un nodo previo y posterior) -- 5 test
 * 9. Comprobar que no es unnodo terminal (Sin haber añadido un elemento, después de añadirlo, después de añadir un nodo previo, un nodo posterior, un nodo previo y posterior) -- 5 test
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("A DequeNode")
class DequeNodeTest {
    DequeNode<Integer> integerDequeNode;

    @Order(1)
    @Nested
    @DisplayName("when create")
    class isInstantiated {

        @Test
        @DisplayName("deque node with all null parameters")
        void DequeNodeConstructorElementPreviousAndNextNull() {
            new DequeNode<>(null, null, null);
        }

        @Test
        @DisplayName("deque node with not null previous, although element and next are null")
        void DequeNodeConstructorPreviousNotNullElementAndNextNull() {
            new DequeNode<>(null, new DequeNode<>(null, null, null), null);
        }

        @Test
        @DisplayName("deque node with not null next, although  element and previous are null")
        void DequeNodeConstructorNextNotNullElementAndPreviousNull() {
            new DequeNode<>(null, null, new DequeNode<>(null, null, null));
        }

        @Test
        @DisplayName("deque node with not null next and previous, although element is null")
        void DequeNodeConstructorNextAndPreviousNotNullElementNull() {
            new DequeNode<>(null, new DequeNode<>(null, null, null), new DequeNode<>(null, null, null));
        }


        @Test
        @DisplayName("deque node with not null element, although previous and next are null")
        void DequeNodeConstructorElementNotNullPreviousAndNextNull() {
            new DequeNode<>(1, null, null);
        }

        @Test
        @DisplayName("deque node with not null element and previous, although next is null")
        void DequeNodeConstructorElementAndPreviousNotNullNextNull() {
            new DequeNode<>(1, new DequeNode<>(2, null, null), null);
        }

        @Test
        @DisplayName("deque node with not null element and next, although previous is null")
        void DequeNodeConstructorElementAndNextNotNullPreviousNull() {
            new DequeNode<>(1, null, new DequeNode<>(3, null, null));
        }

        @Test
        @DisplayName("deque node with not null element, next and previous")
        void DequeNodeConstructorElementNextAndPreviousNotNull() {
            new DequeNode<>(1, new DequeNode<>(2, null, null), new DequeNode<>(3, null, null));
        }
    }

    @Order(2)
    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewDequeNode() {
            integerDequeNode = new DequeNode<>(null, null, null);
        }

        @Test
        @DisplayName("returns a null element")
        void returnNullElement() {
            Integer actualElement = integerDequeNode.getItem();

            assertThat(actualElement).isEqualTo(null);
        }

        @Test
        @DisplayName("return a null next node")
        void returnNullNextNode() {
            DequeNode<Integer> actualElement = integerDequeNode.getNext();

            assertThat(actualElement).isEqualTo(null);
        }

        @Test
        @DisplayName("return a null previous node")
        void returnNullPreviousNode() {
            DequeNode<Integer> actualElement = integerDequeNode.getPrevious();

            assertThat(actualElement).isEqualTo(null);
        }

        @Test
        @DisplayName("is first node")
        void isFirstNode() {
            boolean actualElement = integerDequeNode.isFirstNode();

            assertThat(actualElement).isEqualTo(true);
        }

        @Test
        @DisplayName("is last node")
        void isLastNode() {
            boolean actualElement = integerDequeNode.isLastNode();

            assertThat(actualElement).isEqualTo(true);
        }

        @Test
        @DisplayName("is not a terminal node")
        void isNotATerminalNode() {
            boolean actualElement = integerDequeNode.isNotATerminalNode();

            assertThat(actualElement).isEqualTo(false);
        }

        @Nested
        @DisplayName("after adding an element")
        class AfterAddingElement {
            Integer anElement = 1;

            @BeforeEach
            void addingAnElement() {
                integerDequeNode.setItem(anElement);
            }

            @Test
            @DisplayName("returns a not null element")
            void returnNotNullElement() {
                Integer actualElement = integerDequeNode.getItem();
                Integer expectedElement = 1;

                assertThat(actualElement).isEqualTo(expectedElement);
            }

            @Test
            @DisplayName("return a null next node")
            void returnNullNextNode() {
                DequeNode<Integer> actualElement = integerDequeNode.getNext();

                assertThat(actualElement).isEqualTo(null);
            }

            @Test
            @DisplayName("return a null previous node")
            void returnNullPreviousNode() {
                DequeNode<Integer> actualElement = integerDequeNode.getPrevious();

                assertThat(actualElement).isEqualTo(null);
            }

            @Test
            @DisplayName("is first node")
            void isFirstNode() {
                boolean actualElement = integerDequeNode.isFirstNode();

                assertThat(actualElement).isEqualTo(true);
            }

            @Test
            @DisplayName("is last node")
            void isLastNode() {
                boolean actualElement = integerDequeNode.isLastNode();

                assertThat(actualElement).isEqualTo(true);
            }

            @Test
            @DisplayName("is not a terminal node")
            void isNotATerminalNode() {
                boolean actualElement = integerDequeNode.isNotATerminalNode();

                assertThat(actualElement).isEqualTo(false);
            }

            @Nested
            @DisplayName("after adding a previous node")
            class AfterAddingPreviousNode {
                DequeNode<Integer> previous = new DequeNode<>(2, null, null);

                @BeforeEach
                void addingAPreviousNode() {
                    integerDequeNode.setPrevious(previous);
                }

                @Test
                @DisplayName("returns a not null element")
                void returnNotNullElement() {
                    Integer actualElement = integerDequeNode.getItem();
                    Integer expectedElement = 1;

                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("return a null next node")
                void returnNullNextNode() {
                    DequeNode<Integer> actualElement = integerDequeNode.getNext();

                    assertThat(actualElement).isEqualTo(null);
                }

                @Test
                @DisplayName("return a not null previous node")
                void returnNullPreviousNode() {
                    DequeNode<Integer> actualElement = integerDequeNode.getPrevious();
                    DequeNode<Integer> expectedElement = previous;


                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("is not first node")
                void isFirstNode() {
                    boolean actualElement = integerDequeNode.isFirstNode();

                    assertThat(actualElement).isEqualTo(false);
                }

                @Test
                @DisplayName("is last node")
                void isLastNode() {
                    boolean actualElement = integerDequeNode.isLastNode();

                    assertThat(actualElement).isEqualTo(true);
                }

                @Test
                @DisplayName("is not a terminal node")
                void isNotATerminalNode() {
                    boolean actualElement = integerDequeNode.isNotATerminalNode();

                    assertThat(actualElement).isEqualTo(false);
                }
            }

            @Nested
            @DisplayName("after adding a next node")
            class AfterAddingNextNode {
                DequeNode<Integer> next = new DequeNode<>(2, null, null);

                @BeforeEach
                void addingANextNode() {
                    integerDequeNode.setNext(next);
                }

                @Test
                @DisplayName("returns a not null element")
                void returnNotNullElement() {
                    Integer actualElement = integerDequeNode.getItem();
                    Integer expectedElement = 1;

                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("return a not null next node")
                void returnNullNextNode() {
                    DequeNode<Integer> actualElement = integerDequeNode.getNext();
                    DequeNode<Integer> expectedElement = next;

                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("return a null previous node")
                void returnNullPreviousNode() {
                    DequeNode<Integer> actualElement = integerDequeNode.getPrevious();


                    assertThat(actualElement).isEqualTo(null);
                }

                @Test
                @DisplayName("is first node")
                void isFirstNode() {
                    boolean actualElement = integerDequeNode.isFirstNode();

                    assertThat(actualElement).isEqualTo(true);
                }

                @Test
                @DisplayName("is not last node")
                void isLastNode() {
                    boolean actualElement = integerDequeNode.isLastNode();

                    assertThat(actualElement).isEqualTo(false);
                }

                @Test
                @DisplayName("is not a terminal node")
                void isNotATerminalNode() {
                    boolean actualElement = integerDequeNode.isNotATerminalNode();

                    assertThat(actualElement).isEqualTo(false);
                }
            }

            @Nested
            @DisplayName("after adding a next and previous node")
            class AfterAddingNextAndPreviousNode {
                DequeNode<Integer> next = new DequeNode<>(2, null, null);
                DequeNode<Integer> previous = new DequeNode<>(3, null, null);

                @BeforeEach
                void addingANextNode() {
                    integerDequeNode.setNext(next);
                    integerDequeNode.setPrevious(previous);
                }

                @Test
                @DisplayName("returns a not null element")
                void returnNotNullElement() {
                    Integer actualElement = integerDequeNode.getItem();
                    Integer expectedElement = 1;

                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("return a not null next node")
                void returnNullNextNode() {
                    DequeNode<Integer> actualElement = integerDequeNode.getNext();
                    DequeNode<Integer> expectedElement = next;

                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("return a not null previous node")
                void returnNullPreviousNode() {
                    DequeNode<Integer> actualElement = integerDequeNode.getPrevious();
                    DequeNode<Integer> expectedElement = previous;


                    assertThat(actualElement).isEqualTo(expectedElement);
                }

                @Test
                @DisplayName("is not first node")
                void isFirstNode() {
                    boolean actualElement = integerDequeNode.isFirstNode();

                    assertThat(actualElement).isEqualTo(false);
                }

                @Test
                @DisplayName("is not last node")
                void isLastNode() {
                    boolean actualElement = integerDequeNode.isLastNode();

                    assertThat(actualElement).isEqualTo(false);
                }

                @Test
                @DisplayName("is not a terminal node")
                void isNotATerminalNode() {
                    boolean actualElement = integerDequeNode.isNotATerminalNode();

                    assertThat(actualElement).isEqualTo(true);
                }
            }
        }
    }
}