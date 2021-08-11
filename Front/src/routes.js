import React from 'react';

import Home from './pages/App';
import Despesas from './pages/Despesas';

import { Switch, Route } from 'react-router-dom';

function Routes() {
    return(
        <Switch>
            <Route path="/" component={Home} exact />
            <Route path="/despesas" component={Despesas} />
        </Switch>
    );
}

export default Routes;