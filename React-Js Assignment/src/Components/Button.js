import React from 'react';

class Button extends React.Component {

    render() {

        const { ButtonValue, onClick} = this.props;
        return (

            <button onClick={onClick}> {ButtonValue} </button>

        );
    }
}

export default Button;