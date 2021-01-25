import React from 'react';

class InputText extends React.Component {

    render() {

        const { value, onChange, placeholder } = this.props;

        return (
            <div>
                <input
                    type="text"
                    value={value}
                    onChange={onChange}
                    placeholder={placeholder}
                >
                </input>
            </div>
        );
    }
}

export default InputText;