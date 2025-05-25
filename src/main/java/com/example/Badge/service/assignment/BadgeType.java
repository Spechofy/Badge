package com.example.Badge.service.assignment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * The enum Badge type.
 */
@Getter
@RequiredArgsConstructor
public enum BadgeType {

    /**
     * Badge attribué aux utilisateurs
     * qui laissent des commentaires constructifs et engageants.
     */
    COMMENTAIRES("Badge Commentaires",
            "Récompense les commentaires constructifs et fréquents."),

    /**
     * Badge attribué aux utilisateurs évalués positivement lors de matchs.
     */
    EVALUATIONS_POSITIVES(
            "Badge Évaluations Positives",
            "Récompense les évaluations positives reçues lors des matchs."),

    /**
     * Badge attribué en fonction de
     * la compatibilité musicale avec d'autres utilisateurs.
     */
    COMPATIBILITE_MUSICALE(
            "Badge Compatibilité Musicale",
            "Récompense une forte "
                    + "compatibilité musicale avec les autres membres."),

    /**
     * Badge attribué en fonction de la participation à des événements musicaux.
     */
    PARTICIPATION(
            "Badge Participation",
            "Récompense l’implication "
                    + "dans les événements musicaux de la plateforme.");

    /**
     * The Display name.
     */
    private final String displayName;
    /**
     * The Description.
     */
    private final String description;



}
