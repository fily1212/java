import React, { Component } from 'react';
import { getPosts } from '../util/APIUtils';
import './Home.css';


let posts = [];
getPosts().then(response => {
    posts=[];
    response.map(
        (item) => posts.push(item)
    )}
)


class Home extends Component {

    componentDidMount(){
        posts=[];
        getPosts().then(response => 
            response.map(
                (item) => posts.push(item)
            )
        )
        
        this.forceUpdate();
    }

    
    render() {

        return (
            <div className="home-container">
                <div className="container">

                    {
                        posts.map((item)=>{
                            return <div> 
                                {item.description}
                            </div>
                        }
                        )
                    }


                    <div className="graf-bg-container">
                        <div className="graf-layout">
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                            <div className="graf-circle"></div>
                        </div>
                    </div>
                    <h1 className="home-title">Spring Boot React OAuth2 Social Login Demo</h1>
                </div>
            </div>
        )
    }
}

export default Home;