import React from 'react';
import './App.css';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      items: [],
      cart: {
        id: 0,
        items: []
      }
    };
    this.addToCart = this.addToCart.bind(this);
//    this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/item", {
                "method": "GET",
                "headers": {
                  "content-type": "application/json",
                }
              })
              .then(response => response.json())
              .then(response => {
                this.setState({
                  items: response
                })
              })
              .catch(err => { console.log(err);
              });
        fetch("http://localhost:8080/api/cart", {
                 "method": "POST",
                 "headers": {
                   "content-type": "application/json",
                 }
               })
               .then(response => response.json())
               .then(response => {
                 if (!response.items) {
                    response.items = [];
                 }
                 this.setState({
                   cart: response
                 })

               })
               .catch(err => { console.log(err);
               });
    }

    addToCart(itemId) {
        fetch("http://localhost:8080/api/cart"+this.state.cart.id+"item/"+itemId, {
          "method": "POST",
          "headers": {
            "content-type": "application/json",
            "accept": "application/json"
             }
          }
        )
        .then(response => response.json())
        .then(response => {
          console.log(response)
        })
        .catch(err => {
          console.log(err);
        });
    }

  render() {
      return (
        <div className="App">
            <div>Items you can add to your cart:</div>
            {this.state.items.map(item =>
                <div>
                    {item.name}
                    <button className="btn btn-primary" type='button' onClick={(e) => this.addToCart(item.id)}>
                        Add to Cart
                    </button>
                </div>
            )}
            <br/><br/>
            <div>Items in your cart:</div>

            {this.state.cart.items.map(item =>
                <div>
                    {item.name}
                </div>
            )}

        </div>
      );
  }
}

export default App;
