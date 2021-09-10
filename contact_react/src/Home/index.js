import React, { Component } from 'react';
import TopNav from '../Components/topNav';

import HomeView from './view';

export default class Home extends Component {
    render() {
        return (
            <div>
                <TopNav />
                <HomeView />
            </div>
        );
    }
}