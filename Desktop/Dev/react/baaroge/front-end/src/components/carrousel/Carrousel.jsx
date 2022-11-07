import React from "react";
import "./carrousel.scss"
import {Carousel, Badge, Alert} from 'react-bootstrap';
import logo from "../../assets/logo.png";



function Carrousel(props) {
  const pictures = require.context("../../assets", true);
    return ( 
        <div className="col-12">
      
      <Carousel>
        {props.imgs.map(prop =>
          
          <Carousel.Item interval={1500}>
            <img
              className="d-block w-100"
              src={pictures(prop.img)}
              alt={prop.title}
            />
            <Carousel.Caption className="bg-dark-transparent">
              <h3>{prop.title}</h3>
              <p>{prop.description}</p>
              <Badge bg="secondary" as="h1">
                  New
              </Badge>
            </Carousel.Caption>
          </Carousel.Item>
          
          )}
        
        
      </Carousel>

      
    </div>
    );
}
export default Carrousel;