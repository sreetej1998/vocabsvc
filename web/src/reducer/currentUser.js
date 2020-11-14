const initialState = {
  name: undefined,
  email: undefined,
};

function currentUser(state = initialState, action) {
  switch (action.type) {
    case 'SET_USER': return { ...state, ...action.payload };
    default: return state;
  }
}

export default currentUser;
