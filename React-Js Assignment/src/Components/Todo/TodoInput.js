import React from "react";

class TodoInput extends React.Component{
    render(){
        const {value, onChange, placeholder} = this.props;
        
        return( 
            <input
                type="text" 
                placeholder = {placeholder}
                value = {value} 
                onChange={onChange}
            />
        );
    }
}

export default TodoInput;
