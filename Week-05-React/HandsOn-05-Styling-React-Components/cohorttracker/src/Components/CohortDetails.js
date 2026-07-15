import styles from "./CohortDetails.module.css";

function CohortDetails(props) {

    const cohort = props.cohort;

    return (

        <div className={styles.box}>

            <h3>{cohort.cohortCode}</h3>

            <dl>

                <dt>Started On</dt>
                <dd>{cohort.startDate}</dd>

                <dt>Current Status</dt>

                <dd>

                    <h3
                        style={{
                            color:
                                cohort.currentStatus === "Ongoing"
                                    ? "green"
                                    : "blue"
                        }}
                    >
                        {cohort.currentStatus}
                    </h3>

                </dd>

                <dt>Coach</dt>
                <dd>{cohort.coach}</dd>

                <dt>Trainer</dt>
                <dd>{cohort.trainer}</dd>

            </dl>

        </div>

    );

}

export default CohortDetails;