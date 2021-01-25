import { checkPropTypes } from "prop-types";
import React from "react";
import PropTypes from "prop-types";

class TodoList extends React.Component{

    static propTypes = {
        todos: PropTypes.arrayOf(
            PropTypes.shape({
                todo : PropTypes.string,
                marked : PropTypes.bool,
            })
        ),
    };

    render(){
        const { todos, title } = this.props;
        return (
            <div>
                <h4>{title}</h4>
                <ul>
                    {todos ? 
                        todos.map((todo, index)=>{
                        return (
                            <li key = {index}> 
                            <label
                                style = {
                                    todo.marked ? {
                                        textDecoration : "line-through"
                                    } 
                                        :{}
                                }
                            > <input type = "checkbox" checked={todo.marked} 
                                onChange={() => this.props.markTaskAsCompleted(index)}
                                />
                                {todo.todo}
                            </label>    
                             
                            </li>
                        ) 
                    }) 
                    : null}
                </ul> 
            </div>
         )
    }
}

export default TodoList;

