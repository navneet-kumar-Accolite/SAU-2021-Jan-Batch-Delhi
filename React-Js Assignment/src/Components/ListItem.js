import React from 'react';

class ListItem extends React.Component {

    render() {
        const { todo, index, deleteTask, duplicateTask, toggleTodoMarked } = this.props;
        return (
            <div >
                <input
                    type="checkbox"
                    checked={todo.completed}
                    onChange={() => toggleTodoMarked(index)} />
                
                <span style={todo.completed ? { textDecoration: 'line-through' } : null}>
                    {todo.task}
                </span>


                <button onClick={() => deleteTask(index)}>Delete</button>
                <button onClick={() => duplicateTask(index)}>Duplicate </button>

            </div>

        );
    }
}

export default ListItem;