import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    tweets: []
  };

  async componentDidMount() {
    const response = await fetch('/twitterfeeds/get_tweets/ipl');
    const body = await response.json();
    this.setState({ tweets: body.data, isLoading: false });
  }
  
  render() {
    const {tweets, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <div className="App-intro">
            <h2>Tweet Search</h2>
            {tweets.map(tweet =>
              <div key={tweet.id}>
                {tweet.text}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
  
}

export default App;
