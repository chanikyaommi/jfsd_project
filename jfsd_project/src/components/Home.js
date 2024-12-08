import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Home.css'; // Importing the CSS for styling
import '../App.css'

const Home = () => {
  const [events, setEvents] = useState([]);

  // Fetch events when the component mounts
  useEffect(() => {
    axios.get('http://localhost:8080/events')
      .then((response) => setEvents(response.data))
      .catch((error) => console.log("Error fetching events:", error));
  }, []);

  return (
    <div className='App-body'>
      <div className='App-body-header'>
        <h1>Welcome to the Extracurricular Activities Platform</h1>
      </div>
      <div className="App-body-about">
        <h2>Upcoming Events</h2>
        {events.length > 0 ? (
          <div className="Events-list">
            {events.map((event, index) => (
              <div className="Event-card" key={index}>
                <img src={`data:image/jpeg;base64,${event.image}` || 'default-image-url.jpg'} alt={event.eventName} className="Event-image" />
                <div className="Event-details">
                  <h3>{event.eventName}</h3>
                  <p>{event.description}</p>
                  <button>Learn More</button>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <p>No upcoming events.</p>
        )}
      </div>
    </div>
  );
};

export default Home;
