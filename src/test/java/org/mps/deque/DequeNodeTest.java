package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("A DequeNode")
class DequeNodeTest {

    @DisplayName("integer type")
    static
    class IntegerDequeNode {
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
                new DequeNode<>(null, new DequeNode<>(2, null, null), null);
            }

            @Test
            @DisplayName("deque node with not null next, although  element and previous are null")
            void DequeNodeConstructorNextNotNullElementAndPreviousNull() {
                new DequeNode<>(null, null, new DequeNode<>(3, null, null));
            }

            @Test
            @DisplayName("deque node with not null next and previous, although element is null")
            void DequeNodeConstructorNextAndPreviousNotNullElementNull() {
                new DequeNode<>(null, new DequeNode<>(2, null, null), new DequeNode<>(3, null, null));
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
}