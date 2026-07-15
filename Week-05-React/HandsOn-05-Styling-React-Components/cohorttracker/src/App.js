import "./App.css";

import cohortData from "./data";
import CohortDetails from "./Components/CohortDetails";

function App() {

  return (

    <div>

      <h1 style={{ textAlign: "center" }}>
        Cohorts Details
      </h1>

      {

        cohortData.map((cohort) => (

          <CohortDetails
            key={cohort.id}
            cohort={cohort}
          />

        ))

      }

    </div>

  );

}

export default App;