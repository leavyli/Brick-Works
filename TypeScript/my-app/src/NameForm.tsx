import React from "react";

type Props = {
  messageFunc?: () => void;
};
type State = {
  value: string;
};

export class NameForm extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = {
      value: "",
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

//   handleChange(event: React.FormEvent<HTMLInputElement>) {
//     this.setState({ value: event.currentTarget.value });
//   }
  handleChange: React.ChangeEventHandler<HTMLInputElement> = (event)=>{
    this.setState({ value: event.currentTarget.value });
  }


  handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    alert("A name was submitted: " + this.state.value);
    if (this.props.messageFunc) {
      this.props.messageFunc();
    }
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={this.state.value}
            onChange={this.handleChange}
          />
        </label>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}
